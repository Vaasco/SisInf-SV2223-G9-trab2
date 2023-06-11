package data_mappers;

import model.Normal;
import model.Normald;


public interface INormalMapper extends IDataMapper<Normal, Normald> {
    Normal read(String idGame, String nomeCracha) throws Exception;

    //Crachas read(String idGame, String nomeCracha) throws Exception;
}