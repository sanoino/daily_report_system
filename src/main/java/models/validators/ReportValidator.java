package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ReportView;
import constants.MessageConst;

/**
 * 日報インスタンスに設定されている値のバリデーションを行うクラス
 */
public class ReportValidator {

    /**
     * 日報インスタンスの各項目についてバリデーションを行う
     * @param rv 日報インスタンス
     * @return エラーのリスト
     */
    public static List<String> validate(ReportView  rv){
        List<String> errors = new ArrayList<String>();

        //タイトルのチェック
        String titleError = validateTitle(rv.getTitle());
        if(!titleError.equals("")) {
            errors.add(titleError);
        }

        //内容のチェック
        String contentError = validateContent(rv.getContent());
        if(!contentError.equals("")) {
            errors.add(contentError);
        }

        //商談先のチェック
        String partnerError = validatePartner(rv.getPartner());
        if(!partnerError.equals("")) {
            errors.add(partnerError);
        }

        //内容のチェック
        String meetingError = validateMeeting(rv.getMeeting());
        if(!meetingError.equals("")) {
            errors.add(meetingError);
        }

        return errors;
    }

    /**
     * タイトルに入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param title タイトル
     * @return エラーメッセージ
     */
    private static String validateTitle(String title) {
        if(title == null || title.equals("")) {
            return MessageConst.E_NOTITLE.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     */
    private static String validateContent(String content) {
        if(content == null || content.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 商談先に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param client 商談先
     * @return エラーメッセージ
     */
    private static String validatePartner(String partner) {
        if(partner == null || partner.equals("")) {
            return MessageConst.E_NOPARTNER.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 商談状況に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param meeting 商談状況
     * @return エラーメッセージ
     */
    private static String validateMeeting(String meeting) {
        if(meeting == null || meeting.equals("")) {
            return MessageConst.E_NOMEETING.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

}
