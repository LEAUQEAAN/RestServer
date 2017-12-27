<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <input type="text" id="code" name="code" required placeholder="输入账号...." />
        <input type="password" id="pwd" name="pwd" required  placeholder="输入密码...." />
        <input type="button" onclick="login()"   value="登陆" />
    <br/>

    <form action="./upload" method="post" enctype="multipart/form-data" >
        <input type="file" id="file" name="file"  />
        <input type="submit"  value="上传" />
    </form>

    <form action="./mupload" method="post" enctype="multipart/form-data" >
        <input type="file" name="files"  />
        <input type="file" name="files"  />
        <input type="file" name="files"  />
        <input type="file" name="files"  />
        <input type="file" name="files"  />
        <input type="submit"  value="上传" />
    </form>



    <div>
        <img alt="" src="${fileUrl}" />
    </div>
    <div>
        <form action="./download" method="post"  >
            <input type="text"  name="fileName" value="${fileName}"  required readonly />
            <input type="submit"  value="下载" />
        </form>
    </div>
</body>
<script src="jquery/jquery-3.1.1.min.js" ></script>
<script>
    function login()
    {
        var params = {};
        // params.XX必须与Spring Mvc controller中的参数名称一致
        // 否则在controller中使用@RequestParam绑定
        params.code = document.getElementById("code").value;
        params.pwd = document.getElementById("pwd").value;
        $.ajax({
            async: false,
            type: "POST",
            url: "./login",// 注意路径
            data: params,
            dataType: "json",
            success: function (data) {
                if (data) {
                    alert(JSON.stringify(data, null, 4));
                    if(data.user==null){
                        alert("用户不存在！！");
                    }else if(data.groupInfos==null){
                        alert("密码错误！！");
                    }else{
                        window.open("main.jsp","_self");
                    }



                }
            },
            error: function (data) {
                alert(JSON.stringify(data, null, 4));
            }
        });
    }

</script>

</html>
