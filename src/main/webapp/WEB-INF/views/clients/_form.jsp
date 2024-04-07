<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="action" value="${ForwardConst.ACT_CLI.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />

<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="${AttributeConst.CLI_CODE.getValue()}">顧客番号</label><br />
<input type="text" name="${AttributeConst.CLI_CODE.getValue()}" id="${AttributeConst.CLI_CODE.getValue()}" value="${client.code}" />
<br /><br />

<label for="${AttributeConst.CLI_NAME.getValue()}">氏名</label><br />
<input type="text" name="${AttributeConst.CLI_NAME.getValue()}" id="${AttributeConst.CLI_NAME.getValue()}" value="${client.name}" />
<br /><br />

<input type="hidden" name="${AttributeConst.CLI_ID.getValue()}" value="${client.id}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">登録</button>