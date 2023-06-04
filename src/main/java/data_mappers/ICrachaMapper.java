package data_mappers;

import model.Crachas;
import model.CrachasId;

public interface ICrachaMapper extends IDataMapper<Crachas, String>{
    Crachas read(String idGame, String nomeCracha) throws Exception;

}
