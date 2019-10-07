<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-task">Add new Task</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Tasks</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="25%">Description</th>
						<th width="25%">Due Date</th>
						<th width="25%">Creation Date</th>
						<th width="25%">Update/Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tasks}" var="task">
						<tr>
							<td>${task.description}</td>
							<td><fmt:formatDate value="${task.duedate}"
									pattern="yyyy-MM-dd HH:mm" /></td>
							<td><fmt:formatDate value="${task.createdat}"
									pattern="yyyy-MM-dd HH:mm" /></td>
							<td><a type="button" class="btn btn-success"
								href="/update-task?id=${task.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete-task?id=${task.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
