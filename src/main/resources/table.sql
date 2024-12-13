# 데이터베이스 생성
create database if not exists students;

# 계정 생성
create user 'student'@'%' identified by '1234';
grant all privileges on students.* to 'student'@'%';
flush privileges;

# 테이블 생성
CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200),
    major VARCHAR(500)
);