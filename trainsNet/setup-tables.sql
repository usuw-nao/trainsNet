int[][] zaseki = new int[5][10]; //1列10席 * 5列
//すべての席を空席で初期化 空席は0とする
for(int row=0; row < 5; row++){
for(int col=0; col < 10; col++){
zaseki[row][col] = 0;
}
}
//A4 A5は予約済に設定
zaseki[0][3] = 1;
zaseki[0][4] = 1;

char retsu = 'A';

for(int row=0; row < 5; row++){
System.out.printf("%c列 ",retsu+row);//列名を英字で表示
for(int col=0; col < 10; col++){
if(zaseki[row][col] == 0){ //空席の場合Oを表示
System.out.print("O");
}
else{//予約済の場合Xを表示
System.out.print("X");
}
}
System.out.println();
}

/* 実行結果
A列 OOOXXOOOOO
B列 OOOOOOOOOO
C列 OOOOOOOOOO
D列 OOOOOOOOOO
E列 OOOOOOOOOO
*/




create database mytrains_db
character set utf8mb4
create database mytrains_db character set utf8mb4 collate utf8mb4_general_ci;
use mytrains_db;

create table adult
(
   id int primary key auto_increment,
   login_id varchar (30) unique key not null,
   login_pass varchar (255) not null,
   nick_name varchar (30) not null,
   type_id int not null,
   email varchar (60) unique key not null,
   point int,
   name varchar (30) not null,
   address varchar (255) not null,
   age int not null,
   ivent int,
   distance varchar (255),
   start_date date,
   end_date date,
   date datetime DEFAULT NULL
);
INSERT INTO adult VALUES
(
   1,
   'sapporo',
   '$2a$08$agTSm068nTYmqcAaaT/WqOs0nvM0y5S9lUPmApWlL1AeZkHRtw6iy',
   'さっぽろ',
   1,
   'sapporo@example.com',
   10,
   '北海道札幌',
   '北海道札幌函館利尻',
   50,
   2,
   '函館から札幌経由稚内経由利尻',
   20220801,
   20221031,
   20220731
);
//イベントテーブル作成 （ここのみ連休中更新ない）
create table ivent
(
   id int primary key auto_increment,
   name varchar (30) not null,
   detail varchar (255) not null,
   place varchar (60) not null,
   day date not null
);
insert into ivent values
(
   1,
   '駅員さんとハイタッチ',
   '東京駅の駅長と座談会をし、その後ハイタッチをするイベントです。知られざる東京駅の秘密や裏話を聞くチャンス☆彡参加人数：10人',
   '東京駅駅長室',
   20220910
);
insert into ivent values
(
   2,
   '駅員さんとハイタッチ',
   '稚内駅の駅長と座談会をし、その後ハイタッチをするイベントです。知られざる稚内駅の秘密や裏話を聞くチャンス☆彡参加人数：10人',
   '稚内駅駅長室',
   20220831
);
insert into ivent values
(
   3,
   'ラキューで名古屋城を作ろう',
   '名古屋駅広場でラキューを使って名古屋城を作ってみませんか？一人で作ってもよし、友達と協力してもよし！ラキューは現地にてお渡しするので手ぶら参加でお越しください。未就学児には保護者の方が必ずご一緒してください',
   '名古屋駅広場',
   20220810
);
insert into ivent values
(
   4,
   'ラキューで五稜郭を作ろう',
   '函館駅みんなの広場でラキューを使って五稜郭を作ってみませんか？一人で作ってもよし、友達と協力してもよし！ラキューは現地にてお渡しするので手ぶら参加でお越しください。未就学児には保護者の方が必ずご一緒してください',
   '函館駅みんなの広場',
   20220823
);
UPDATE adult SET ivent = ivent + 1
WHERE
   id = 1;
//クイズテーブル 最終版 create table adult_quiz
(
   id int primary key auto_increment,
   type_id int not null,
   content varchar (255) not null,
   choice1 varchar (50) not null,
   choice2 varchar (50) not null,
   answer varchar (10) not null,
   date datetime default null
);
insert into adult_quiz values
(
   1,
   1,
   '北海道の県庁所在地は？',
   '札幌',
   '函館',
   '札幌'
);
insert into adult_quiz values
(
   2,
   1,
   '沖縄の県庁所在地は？',
   '与那国',
   '那覇',
   '那覇'
);
insert into adult_quiz values
(
   3,
   2,
   '北海道のお土産、〇〇恋人、〇〇に入る言葉は？',
   '白い',
   '黒い',
   '白い'
);
insert into adult_quiz values
(
   4,
   2,
   '神奈川県のけんちょうしょざいち　は？',
   '川崎',
   '横浜',
   '横浜'
);
連休中に新しく
create table ivent_mutter (
id int primary key auto_increment,
name varchar(20) not null,
text varchar(255) not null,
ivent_name varchar(30) not null,
date datetime DEFAULT NULL

);