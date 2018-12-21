<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        /*初始添加对话框*/
        $("#addBannerDialog").dialog({
            title: 'add banner',
            width: 400,
            height: 250,
            closed: true,
            cache: false,
            href: '${pageContext.request.contextPath}/datagrid/addbanner.jsp'

        })



        var toolbar = [{
            /*添加功能*/
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                /*点击获取选中行*/
                var row = $("#dg").edatagrid("getSelected");

                    /*然后弹出添加对话框*/
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#addBannerDialog").dialog("open");


            }
        }, '-', {
            /*修改功能*/
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                var id=row.id;
                console.log(id);
                if (row != null) {
                    //编辑指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", index);

                } else {
                    alert("请先选中行")
                }


            }
        }, '-', {
            /*删除功能*/
            text: "删除",
            iconCls: 'icon-remove',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                var id=row.id;

                if (row != null) {
                    //编辑指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);

                    $("#dg").edatagrid("destroyRow");

                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            /*保存*/
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg").edatagrid("saveRow")

            }
        }]

        $('#dg').edatagrid({
            method: "GET",
            updateUrl: "${pageContext.request.contextPath}/banner/updateBannerStatus",
            destroyUrl:"${pageContext.request.contextPath}/banner/deleteOneBanner",
            destroyMsg:{
                norecord:{    // 在没有记录选择的时候执行
                    title:'Warning',
                    msg:'No record is selected.'
                },
                confirm:{       // 在选择一行的时候执行		title:'Confirm',
                    msg:'Are you sure you want to delete?'
                }
            },


            url: '${pageContext.request.contextPath}/banner/getPageRows',
            columns: [[
                {field: 'title', title: '名称', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: "text",
                        options: {required:true}
                    }
                },
                {field: 'pub_date', title: '时间', width: 100, align: 'right'}
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageList: [1, 3, 5, 7, 9],
            pageSize: 3,
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/showImage/shouye/' + rowData.img_path + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pub_date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });

    })

</script>

<table id="dg"></table>
<%--添加对话框--%>
<div id="addBannerDialog"></div>