--(h 	- versão 2 - 	usando um PA desenvolvido anteriormente)
--
--		Criar o procedimento armazenado associarCrachaV2 que recebe como parâmetros o
--		identificador de um jogador, a referência de um jogo e o nome de um crachá desse jogo e
--		atribui o crachá a esse jogador se ele reunir as condições para o obter.


drop procedure if exists associarCrachaV2;

set transaction isolation level read uncommitted;
create or replace procedure associarCrachaV2(id_p int, id_g VARCHAR(50), cracha_nome VARCHAR(50))
language plpgsql
as $$
DECLARE
	points BigInt;
    v_nome_regiao VARCHAR(40);
BEGIN
    --Verificar se o id_p passado como parâmetro existe na tabela de jogadores.
    if not exists(select * from jogadores where id_player = id_p) then
        raise exception 'O id passado como parâmetro não existe na tabela JOGADORES.';
    end if;

    --Verificar se o id_g passado como parâmetro existe na tabela de jogos.
    if not exists(select * from jogos where id_game = id_g) then
        raise exception 'O id passado como parâmetro não existe na tabela JOGOS.';
    end if;

    --Verificar se o cracha_nome passado como parâmetro existe na tabela de crachas.
    if not exists(select * from crachas where cracha_nome = nome_cracha) then
        raise exception 'O nome passado como parâmetro não existe na tabela CRACHAS.';
    end if;

	select pontos from PontosJogoPorJogador(id_g) where id_jogador = id_p into points;
	select nome_regiao from jogadores where id_player = id_p into v_nome_regiao;
	
    if (
		points >= 
		(select limite_pontos from crachas where id_game = id_g and nome_cracha = cracha_nome)
	)
        then 
			insert into tem (id_player, nome_cracha, id_game, nome_regiao)
        	select id_p, cracha_nome, id_g, v_nome_regiao
        	where not exists(
            	select 1 from tem 
				where id_player = id_p and nome_cracha = cracha_nome and id_game = id_g
			);
   	end if;
	
end
$$;


call associarCrachaV2(1000, '0123456789', 'Test Drive');
select * from tem;
select * from crachas;