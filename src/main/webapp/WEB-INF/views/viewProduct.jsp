<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div class="container-wrapper">
	<div class="container">
		<h2>Product Detail</h2>
		<p>Here is the detail information of the product!</p>
		<div class="row">
			<div class="col-md-6">
				<c:set var="imageFilename"
					value="/resources/images/${product.id}.jpg" />
				<img src="<c:url value="${imageFilename}" />" alt="image"
					style="width: 80%" />
			</div>
			<div class="col-md-6">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p><strong>Manufacturer : </strong>${product.manufacturer}</p>
				<p><strong>Category : </strong>${product.category}</p>
				<p><strong>unitInStock : </strong>${product.unitInStock}</p>
				<h4><strong>${product.price}원</strong></h4>
			</div>

		</div>
	</div>
</div>
