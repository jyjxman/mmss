<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {


        $('#userAddForm').form({
            url : '${path }/repository/add',
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
                    $.messager.alert('提示', result.msg, 'warning');
                }
            }
        });
        
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="userAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>仓库名</td>
                    <td><input name="repositoryName" type="text" placeholder="请输入仓库名" class="easyui-validatebox" data-options="required:true" value=""></td>
                    <td>仓库地址</td>
                    <td><input name="repositoryAddress" type="text" placeholder="请输入仓库地址" class="easyui-validatebox" data-options="required:true" value=""></td>
                </tr>
                <tr>
                    <td>仓库面积</td>
                    <td><input name="repositoryArea" type="text" placeholder="请输入仓库面积" class="easyui-validatebox" data-options="required:true" value=""></td>                     
                </tr>
              <tr>
               <td>仓库描述</td>
              <td> <textarea name="repositoryDesc" style="height:60px;"></textarea></td>
              </tr>
            </table>
        </form>
    </div>
</div>