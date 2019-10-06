<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add/Modify Task</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="task">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="description">Description</form:label>
							<form:input path="description" type="text" class="form-control"
								required="required" />
							<form:errors path="description" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="duedate">Due Date</form:label>
							<form:input path="duedate" type="text" class="form-control"
								required="required" />
							<form:errors path="duedate" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="remindat">Postpone till date</form:label>
							<form:input path="remindat" type="text" class="form-control"
								required="required" />
							<form:errors path="remindat" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>