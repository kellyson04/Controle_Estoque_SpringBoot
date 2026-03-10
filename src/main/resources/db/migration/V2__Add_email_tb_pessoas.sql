-- Migrations para adicionar a coluna de email na tabela de pessoas

ALTER TABLE tb_pessoas
ADD COLUMN email VARCHAR(80);