<%@ page pageEncoding="utf-8"%>

<script type="text/javascript">
    $(function(){
        $("#inp1").textbox({
            required : true,
            type : "text",
            iconCls:"icon-man"

        });
        $("#inp3").filebox({
            buttonText:"选择文件"

        })




        $("#inp3").textbox({
            required : true,
            type : "text"


        });

        $("#inp4").textbox({
            required : true,
            type : "text"


        });

        $("#inp5").textbox({
            required : true,
            type : "text"


        });



        $("#but").linkbutton({
            text:"确认",
            iconCls : "icon-add",
            onClick:function(){
                $("#ff3").form("submit", {
                    url:"${pageContext.request.contextPath }/banner/addBanner",
                    onSubmit: function(){
                        return $("#ff3").form("validate");

                    },
                    success:function(result){
                        console.log(result);

                        $.messager.show({
                            title:"标题",
                            msg:"添加成功！",
                            timeout:2000
                        });
                        $("#ff3").form("clear");
                        $("#addBannerDialog").dialog("close");
                        $("#dg").datagrid("load");
                    }

                });
            }
        });
        $("#but2").linkbutton({
            text:"重置",
            iconCls : "icon-reload",
            onClick:function(){
                $("#ff3").form("clear");
            }
        });

    /*初始化日期输入框*/
        $("#inp4").datebox({
            editable:false
        })


    });
</script>
<form id="ff3" method="post"  enctype="multipart/form-data" >

    名称  &nbsp;&nbsp;&nbsp;;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="inp1" name="title" /></br>
    上传图片  &nbsp;&nbsp;&nbsp;<input id="inp" class="easyui-filebox" name = "uploadFile"></br>
    描述  &nbsp;&nbsp;&nbsp;;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="inp5" name="description" /></br>


</form>
<a id="but"></a>
<a id="but2"></a>