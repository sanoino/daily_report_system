<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.AttributeConst" %>

<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<fmt:parseDate value="${report.reportDate}" pattern="yyyy-MM-dd" var="reportDay" type="date" />
<label for="${AttributeConst.REP_DATE.getValue()}">日付</label><br />
<input type="date" name="${AttributeConst.REP_DATE.getValue()}" id="${AttributeConst.REP_DATE.getValue()}" value="<fmt:formatDate value='${reportDay}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label>氏名</label><br />
<c:out value="${sessionScope.login_employee.name}" />
<br /><br />

<label for="${AttributeConst.REP_TITLE.getValue()}">タイトル</label><br />
<input type="text" name="${AttributeConst.REP_TITLE.getValue()}" id="${AttributeConst.REP_TITLE.getValue()}" value="${report.title}" />
<br /><br />

<label for="${AttributeConst.REP_CONTENT.getValue()}">内容</label><br />
<textarea name="${AttributeConst.REP_CONTENT.getValue()}" id="${AttributeConst.REP_CONTENT.getValue()}" rows="10" cols="50">${report.content}</textarea>
<br /><br />

<label for="${AttributeConst.REP_CLIENT.getValue()}">商談先：</label>
<select name="${AttributeConst.REP_CLIENT.getValue()}" id="${AttributeConst.REP_CLIENT.getValue()}">
  <option value="">--選択してください--</option>
  <c:forEach var="client" items="${clients}">
    <option value="${client.id}"><c:out value="${client.name}"></c:out></option>
  </c:forEach>
</select>
<br /><br />

<label for="${AttributeConst.REP_MEETING.getValue()}">商談状況</label><br />
<textarea name="${AttributeConst.REP_MEETING.getValue()}" id="${AttributeConst.REP_MEETING.getValue()}" rows="10" cols="50">${report.meeting}</textarea>
<br /><br />

<label for="${AttributeConst.REP_STARTED_AT.getValue()}">出勤時間：</label>
<input type="time" id="${AttributeConst.REP_STARTED_AT.getValue()}" name="${AttributeConst.REP_STARTED_AT.getValue()}" value="09:00" required />

<br /><br />

<label for="${AttributeConst.REP_ENDED_AT.getValue()}">退勤時間：</label>
<input type="time" id="${AttributeConst.REP_ENDED_AT.getValue()}" name="${AttributeConst.REP_ENDED_AT.getValue()}" value="18:00" required />
<br /><br />

<input type="hidden" name="${AttributeConst.REP_ID.getValue()}" value="${report.id}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">投稿</button>