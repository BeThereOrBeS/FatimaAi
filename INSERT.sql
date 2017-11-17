LOAD DATA INFILE 'C:\xampp\mysql\data\aibarain.csv'
INTO TABLE aibrain02 FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'; --改行は\rでも可。csvファイルはmysql\dataディレクトリに置くのが好ましい