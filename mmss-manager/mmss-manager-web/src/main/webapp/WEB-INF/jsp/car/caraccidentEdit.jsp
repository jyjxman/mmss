<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
      

        $('#userEditForm').form({
            url : '${path }/caraccident/edit',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success : function(result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.success) {
                   $.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
                   $.modalDialog.handler.dialog('close');
                } else {
                    $.messager.alert('错误', result.msg, 'error');
                }
            }
        });
        
        $("#status").val('${car.status}');
        $("#state").val('${car.state}');
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="userEditForm" method="post">
             <table class="grid">
               <tr>
                    <td>车辆编号</td>
                    <td><input name="id" type="hidden"  value="${caraccident.id}"><input name="carid" type="text" class="easyui-validatebox" data-options="required:true" value="${caraccident.carid}" placeholder="请输入车辆编号" ></td>
                     <td>事故发生地</td>
                    <td><input name="address" type="text" placeholder="请输入事故发生地" class="easyui-validatebox" data-options="required:true" value="${caraccident.address}"></td>
               </tr>
                <tr>
                    <td>所需金额</td>
                    <td><input name="price" type="text" placeholder="请输入所需金额" class="easyui-validatebox" data-options="required:true" value="${caraccident.price}"></td>
                    <td>单位</td>
                    <td><input name="unit" type="text" placeholder="请输入单位" class="easyui-validatebox" data-options="required:true" value="${caraccident.unit}"></td>
                </tr>
                <tr>
                 <td>描述</td>
                <td> <textarea name="reason" style="height:60px;">${caraccident.reason}</textarea></td>
                </tr>
            </table>
        </form>
    </div>
</div>