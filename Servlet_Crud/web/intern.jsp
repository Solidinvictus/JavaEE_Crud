
<!DOCTYPE html>
<div style="background-color:#d2a679; text-align:center;padding: 4px;">
    <fmt:message key='Choose'/>
    <form action="" method="get" >
        <select name="ddlLanguage">
            <option value="en_GB">English</option>
            <option value="es_ES">Español</option>
        </select>
        <input type="submit" value="<fmt:message key='button'/>" > 
<!--        disabled="true"-->
        
    </form>
        <% //out.println("Language selected: " + request.getParameter("ddlLanguage"));%>
    <br>
    
    </div>
