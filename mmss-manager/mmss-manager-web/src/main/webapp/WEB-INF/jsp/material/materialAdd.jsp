<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {


        $('#userAddForm').form({
            url : '${path }/material/add',
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
                    <td>物资名称</td>
                   <td> <input name="materialName" type="text" placeholder="请输入物资名称" class="easyui-validatebox" data-options="required:true" value=""></td>
                    <td>规格</td>
                    <td><input name="specifications"  type="text" placeholder="请输入规格" class="easyui-validatebox" data-options="required:true" value=""></td>
                </tr>
                <tr>
                    <td>物资类型</td>
                    <td><input name="materialType" type="text" placeholder="请输入物资类型" class="easyui-validatebox" data-options="required:true" value=""></td>                     
                    <td>单位</td>
                    <td><input name="measureUnit" type="text" placeholder="请输入单位" class="easyui-validatebox" data-options="required:true" value=""></td>                     
                </tr>
              <tr>
               <td>物资描述</td>
               <td> <textarea name="materialDesc" style="height:60px;"></textarea></td>
              </tr>
            </table>
        </form>
    </div>
</div>