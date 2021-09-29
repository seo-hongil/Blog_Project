<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>

<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
	
<style>
	a {
		text-decoration: none;
	}
	
	table {
		border-collapse: collapse;
		width: 1000px;
		margin-top: 20px;
		text-align: center;
	}
	
	td, th {
		border: 1px solid black;
		height: 50px;
	}
	
	th {
		font-size: 17px;
	}
	
	thead {
		font-weight: 700;
	}
	
	.table_wrap {
		margin: 50px 0 0 50px;
	}
	
	.bno_width {
		width: 12%;
	}
	
	.writer_width {
		width: 20%;
	}
	
	.regdate_width {
		width: 15%;
	}
	
	.updatedate_width {
		width: 15%;
	}
	
	.top_btn {
		font-size: 20px;
		padding: 6px 12px;
		background-color: #fff;
		border: 1px solid #ddd;
		font-weight: 600;
	}
	.pageInfo{
	    list-style : none;
	    display: inline-block;
	  	margin: 50px 0 0 100px;      
	}
	.pageInfo li{
		  float: left;
		  font-size: 20px;
		  margin-left: 18px;
		  padding: 7px;
		  font-weight: 500;
	}
	 a:link {color:black; text-decoration: none;}
	 a:visited {color:black; text-decoration: none;}
	 a:hover {color:black; text-decoration: underline;}
 
 .active{
      background-color: #5F9EA0;
  }
  
  .search_area{
    display: inline-block;
    margin-top: 30px;
    margin-left: 260px;
  }
  .search_area input{
      height: 30px;
    width: 250px;
  }
  .search_area button{
     width: 100px;
    height: 36px;
  }
  .search_area select{
  	height : 35px;
  }
  
</style>
</head>
<body>

	<h1>목록페이지입니다.</h1>
	<form>
	    <div class="search_wrap">
      		<div class="search_area">
		      		 <select name="type">
		                <option value="" <c:out value="${pagedto.pi.type == null?'selected':'' }"/>>--</option>
		                <option value="T" <c:out value="${pagedto.pi.type eq 'T'?'selected':'' }"/>>제목</option>
		                <option value="C" <c:out value="${pagedto.pi.type eq 'C'?'selected':'' }"/>>내용</option>
		                <option value="W" <c:out value="${pagedto.pi.type eq 'W'?'selected':'' }"/>>작성자</option>
		                <option value="TC" <c:out value="${pagedto.pi.type eq 'TC'?'selected':'' }"/>>제목 + 내용</option>
		                <option value="TW" <c:out value="${pagedto.pi.type eq 'TW'?'selected':'' }"/>>제목 + 작성자</option>
		                <option value="TCW" <c:out value="${pagedto.pi.type eq 'TCW'?'selected':'' }"/>>제목 + 내용 + 작성자</option>
		            </select>    
         		 	<input type="text" name="keyword" value="${pagedto.pi.keyword }">
          		<button>Search</button>
      		</div>
  		</div>
	  </form> 		    
	<div class="table_wrap">
		<a href="/board/enroll" class="top_btn">게시판 등록</a>
		<table>
			<thead>
				<tr>
					<th class="bno_width">번호</th>
					<th class="title_width">제목</th>
					<th class="writer_width">작성자</th>
					<th class="regdate_width">작성일</th>
					<th class="updatedate_width">수정일</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="list">
	            <tr>
	                <td><c:out value="${list.bno}"/></td>
	                <td>
		                <a class="move" href='<c:out value="${list.bno}"/>'>
	                        <c:out value="${list.title}"/>
	                    </a>
                    </td>
	                <td><c:out value="${list.writer}"/></td>
	                <td><fmt:formatDate pattern="yyyy/MM/dd"  value="${list.regdate}"/></td>
	                <td><fmt:formatDate pattern="yyyy/MM/dd"  value="${list.updateDate}"/></td>
	            </tr>
	        </c:forEach>
		</table>
		

	    		
		<!--  페이징처리 -->	
		<div class="pageInfo_wrap" >
		        <div class="pageInfo_area">
		        	<ul id="pageInfo" class="pageInfo">
		        		  
		        		  <!-- 이전페이지 버튼 -->
				          <c:if test="${pagedto.prev}">
				              <li class="pageInfo_btn previous"><a href="${pagedto.startPage-1}">Prev</a></li>
				          </c:if>
				          
				          <!-- 게시물 개수만큼 출력  -->
		 				 <c:forEach var="num" begin="${pagedto.startPage}" end="${pagedto.endPage}">
		                    	<li class="pageInfo_btn ${pagedto.pi.pageNum == num ? "active":"" }"><a href="${num}">${num}</a></li>
		                </c:forEach>
		                
		                <!-- 다음페이지 버튼 -->
		                <c:if test="${pagedto.next}">
		                    <li class="pageInfo_btn next"><a href="${pagedto.endPage + 1 }">Next</a></li>
		                </c:if>   
		             </ul>
		        </div>
	    </div>
		
		 <form id="moveForm" method="get">    
		        <input type="hidden" name="pageNum" value="${pagedto.pi.pageNum }">
		        <input type="hidden" name="amount" value="${pagedto.pi.amount }">    
		        <input type="hidden" name="type" value="${pagedto.pi.type }">
		        <input type="hidden" name="keyword" value="${pagedto.pi.keyword }">
    	</form>
	</div>

	<script>
		$(document).ready(function() { // 페이지 로딩시 반드시 처리되게
			let result = '<c:out value="${result}"/>';
			checkAlert(result);

			function checkAlert(result) {
				if (result == ' ') {
					reutrn;
				} else if (result == "enrol success") {	  // 등록완료시 alert
					alert("등록이 완료되었습니다.");	
				
				} else if(result == "modify success"){ // 수정 페이지에서 목록 페이지 이동시 alert 
	            	alert("수정이 완료되었습니다.");
				
	       		} else if(result == "delete success"){ // 수정 페이지에서 삭제 완료 시 alert 
	                alert("삭제가 완료되었습니다.");  
	            }
			}
		});
		
		// 제목 버튼 누르면 form으로 페이징 처리
		 let moveForm = $("#moveForm");
		 
		    $(".move").on("click", function(e){
		        e.preventDefault();
		        
		        moveForm.append("<input type='hidden' name='bno' value='"+ $(this).attr("href")+ "'>");
		        moveForm.attr("action", "/board/getPage");
		        moveForm.submit();
		    });
		    
		    // 페이징처리 (해당 번호를 누르면 페이지 이동)
		    $(".pageInfo a").on("click", function(e){ //pageinfo 클래스 안의 a태그 처리
		    	 
		        e.preventDefault();    // a 태그 동작 중지
		        //form안의 input에 pageNum을 넣었는데, a태그 href에 선택한 번호로 value 변경 
		        moveForm.find("input[name='pageNum']").val($(this).attr("href")); 
		        moveForm.attr("action", "/board/list"); // action = /board/list 로 속성 추가
		        moveForm.submit();
		        
		    });
		    
		    // 검색 기능 
		     $(".search_area button").on("click", function(e){
			        e.preventDefault(); //버튼 동작 멈춤
			        
			        let type = $(".search_area select").val();
			        let keyword = $(".search_area input[name='keyword']").val();
			        
			        if(!type){
			            alert("검색 종류를 선택하세요.");
			            return false;
			        }
			        
			        if(!keyword){
			            alert("키워드를 입력하세요.");
			            return false;
			        }        
			        
			        moveForm.find("input[name='type']").val(type); // 기존 타입에 입력받은 타입으로 변경 
			        moveForm.find("input[name='keyword']").val(keyword); // 기존 키워드에 있는 내용을 입력받은 거로 변경
			        moveForm.find("input[name='pageNum']").val(1);  // 검색시 pageNum을 1로 변경해서 1페이지로 검색되게 만듬
			        moveForm.submit();
		    });
	</script>
</body>
</html>