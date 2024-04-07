package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 顧客データのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_CLI)
@NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_CLI_GET_ALL,
            query = JpaConst.Q_CLI_GET_ALL_DEF),
    @NamedQuery(
            name = JpaConst.Q_CLI_COUNT,
            query = JpaConst.Q_CLI_COUNT_DEF),
    @NamedQuery(
            name = JpaConst.Q_CLI_COUNT_REGISTERED_BY_CODE,
            query = JpaConst.Q_CLI_COUNT_REGISTERED_BY_CODE_DEF),
})

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class Client {

    /**
     * id
     */
    @Id
    @Column(name = JpaConst.CLI_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 顧客番号
     */
    @Column(name = JpaConst.CLI_COL_CODE, nullable = false, unique = true)
    private String code;

    /**
     * 氏名
     */
    @Column(name = JpaConst.CLI_COL_NAME, nullable = false)
    private String name;

    /**
     *登録日時
     */
    @Column(name = JpaConst.CLI_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    @Column(name = JpaConst.CLI_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

    /**
     * 削除された顧客かどうか（現役：0、削除済み：1）
     */
    @Column(name = JpaConst.CLI_COL_DELETE_FLAG, nullable = false)
    private Integer deleteFlag;


}
