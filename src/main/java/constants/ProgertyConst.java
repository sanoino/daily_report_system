package constants;

/*
 * アプリケーションスコープのパラメータ名を定義するEnumクラス
 */
public enum ProgertyConst {

    // ペッパー文字
    PEPPER("pepper");

    private final String text;
    private ProgertyConst(final String text) {
        this.text = text;
    }

    public String getValue() {
        return this.text;
    }

}
