<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {


        $('#userAddForm').form({
            url : '${path }/caroil/add',
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
                    <td>汽车编号</td>
                   <td> <input name="carid" type="text" placeholder="请输入汽车编号" class="easyui-validatebox" data-options="required:true" value=""></td>
                    <td>燃油类型</td>
                    <td><input name="fueltype"  type="text" placeholder="请输入燃油类型" class="easyui-validatebox" data-options="required:true" value=""></td>
                </tr>
                <tr>
                    <td>物资类型</td>
                    <td><input name="unitprice" type="text" placeholder="请输入单价" class="easyui-validatebox" data-options="required:true" value=""></td>                     
                    <td>单位</td>
                    <td><input name="uint" type="text" placeholder="请输入单位" class="easyui-validatebox" data-options="required:true" value=""></td>                     
                </tr>
              </table>
        </form>
    </div>
</div>