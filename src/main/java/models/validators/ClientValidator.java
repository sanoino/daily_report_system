package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ClientView;
import constants.MessageConst;
import services.ClientService;

/**
 * 顧客インスタンスに設定されている値のバリデーションを行うクラス
 *
 */
public class ClientValidator {

    /**
     * 顧客インスタンスの各項目についてバリデーションを行う
     * @param service 呼び出し元Serviceクラスのインスタンス
     * @param cv ClientViewのインスタンス
     * @param codeDuplicateCheckFlag 顧客番号の重複チェックを実施するかどうか(実施する:true 実施しない:false)
     * @return エラーのリスト
     */
    public static List<String> validate(
            ClientService service, ClientView cv, Boolean codeDuplicateCheckFlag){
        List<String> errors = new ArrayList<String>();

        //顧客番号のチェック
        String codeError = validateCode(service, cv.getCode(), codeDuplicateCheckFlag);
        if(!codeError.equals("")) {
            errors.add(codeError);
        }

        //氏名のチェック
        String nameError = validateName(cv.getName());
        if(!nameError.equals("")) {
            errors.add(nameError);
        }

        return errors;
    }

    /**
     * 顧客番号の入力チェックを行い、エラーメッセージを返却
     * @param service ClientServiceのインスタンス
     * @param code 顧客番号
     * @param codeDuplicateCheckFlag 顧客番号の重複チェックを実施するかどうか(実施する:true 実施しない:false)
     * @return エラーメッセージ
     */
    private static String validateCode(ClientService service, String code, Boolean codeDuplicateCheckFlag) {

        //入力値がなければエラーメッセージを返却
        if (code == null || code.equals("")) {
            return MessageConst.C_NOCLI_CODE.getMessage();
        }

        if (codeDuplicateCheckFlag) {
            //顧客番号の重複チェックを実施

            long clientsCount = isDuplicateClient(service, code);

            //同一顧客番号が既に登録されている場合はエラーメッセージを返却
            if (clientsCount > 0) {
                return MessageConst.C_CLI_CODE_EXIST.getMessage();
            }
        }

        //エラーがない場合は空文字を返却
        return "";
    }

    /**
     * @param service ClientServiceのインスタンス
     * @param code 顧客番号
     * @return 顧客テーブルに登録されている同一顧客番号のデータの件数
     */
    private static long isDuplicateClient(ClientService service, String code) {

        long clientsCount = service.countByCode(code);
        return clientsCount;
    }

    /**
     * 氏名に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param name 氏名
     * @return エラーメッセージ
     */
    private static String validateName(String name) {

        if (name == null || name.equals("")) {
            return MessageConst.C_NONAME.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

}
