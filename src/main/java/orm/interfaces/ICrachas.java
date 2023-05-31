package orm.interfaces;

import model.CrachasId;

public interface ICrachas {
    CrachasId getId();
    String getUrl();
    Integer getLimitePontos();

    void setId(CrachasId id);
    void setUrl(String url);
    void setLimitePontos(Integer limitePontos);
}
