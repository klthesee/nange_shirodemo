<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="/login" method="post">
        <table>
            <#if msg??>
                <p style="color: red">${msg}</p>
            </#if>
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" name="username"/>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input type="password" name="password"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="登录">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>