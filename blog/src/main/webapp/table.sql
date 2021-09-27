
create table blog_board( --게시판 테이블
    bno int auto_increment, -- 게시판 번호 자동증가
    title varchar(150),			-- 제목
    content varchar(2000),  -- 내용
    writer varchar(50),			-- 작성자
    regdate timestamp default now(), --등록일자
    updatedate timestamp default now(), --수정일자
    constraint pk_board PRIMARY key(bno) --기본키 설정 
);
 