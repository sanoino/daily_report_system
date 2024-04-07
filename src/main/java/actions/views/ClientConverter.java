package actions.views;

import java.util.ArrayList;
import java.util.List;

import constants.AttributeConst;
import constants.JpaConst;
import models.Client;

/**
 * 顧客データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class ClientConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param cv ClientViewのインスタンス
     * @return Clientのインスタンス
     */
    public static Client toModel(ClientView cv) {

        return new Client(
                cv.getId(),
                cv.getCode(),
                cv.getName(),
                cv.getCreatedAt(),
                cv.getUpdatedAt(),
                cv.getDeleteFlag() == null
                        ? null
                        : cv.getDeleteFlag() == AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                                ? JpaConst.CLI_DEL_TRUE
                                : JpaConst.CLI_DEL_FALSE);
    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param c Clientのインスタンス
     * @return ClientViewのインスタンス
     */
    public static ClientView toView(Client c) {

        if(c == null) {
            return null;
        }

        return new ClientView(
                c.getId(),
                c.getCode(),
                c.getName(),
                c.getCreatedAt(),
                c.getUpdatedAt(),
                c.getDeleteFlag() == null
                        ? null
                        : c.getDeleteFlag() == JpaConst.CLI_DEL_TRUE
                                ? AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                                : AttributeConst.DEL_FLAG_FALSE.getIntegerValue());
    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<ClientView> toViewList(List<Client> list){
        List<ClientView> cvs = new ArrayList<>();

        for(Client c : list) {
            cvs.add(toView(c));
        }

        return cvs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param e DTOモデル(コピー先)
     * @param ev Viewモデル(コピー元)
     */
    public static void copyViewToModel(Client c, ClientView cv) {
        c.setId(cv.getId());
        c.setCode(cv.getCode());
        c.setName(cv.getName());
        c.setCreatedAt(cv.getCreatedAt());
        c.setUpdatedAt(cv.getUpdatedAt());
        c.setDeleteFlag(cv.getDeleteFlag());
    }

}
