package data_mappers;

import model.Crachas;


public interface ICrachaMapper extends IDataMapper<Crachas, String> {
    Crachas read(String idGame, String nomeCracha) throws Exception;
}