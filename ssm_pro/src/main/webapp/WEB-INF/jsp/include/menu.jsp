
<div id="wrapper">

	<!-- Sidebar -->
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<li class="sidebar-brand"><a href="#"> Start Bootstrap </a></li>
			<li><a href="#">Dashboard</a></li>
			<li><a href="#">Shortcuts</a></li>
			<li><a href="#">Overview</a></li>
			<li><a href="#">Events</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Services</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</div>
	<!-- /#sidebar-wrapper -->


</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="assets/bootstrap/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="assets/bootstrap/js/bootstrap.min.js"></script>

<!-- Menu Toggle Script -->
<script>
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("toggled");
	});
</script>