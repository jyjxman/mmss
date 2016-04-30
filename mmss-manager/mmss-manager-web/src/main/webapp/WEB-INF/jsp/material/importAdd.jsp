<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {

    
        $('#userAddForm').form({
            url : '${path }/import/add',
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
                    <td>物资编号</td>
                    <td><input name="materialId" type="text" placeholder="请输入物资编号" class="easyui-validatebox" data-options="required:true" value=""></td>
                    <td>仓库编号</td>
                    <td><input name="repositoryId" type="text" placeholder="请输入仓库编号" class="easyui-validatebox" data-options="required:true" value=""></td>
                </tr>
                <tr>
                    <td>入库数量</td>
                    <td><input name="imponum" type="text" placeholder="请输入入库数量" class="easyui-textbox" ></td>
                   <td>数量单位</td>
                    <td><input type="text" name="numunit" placeholder="请输入数量单位" class="easyui-textbox"/></td>
                </tr>
           
                  <tr>
                    <td>入库价格</td>
                    <td><input name="impoprice" type="text" placeholder="请输入入库价格" class="easyui-textbox" ></td>
                   <td>价格单位</td>
                    <td><input name="priceunit" type="text" placeholder="请输价格单位" class="easyui-textbox"></td>
                </tr>
                  <tr>
               <td>入库描述</td>
               <td> <textarea name="impodesc" style="height:60px;"></textarea></td>
              </tr>
            </table>
        </form>
    </div>
</div>