module TESTEORM2 {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires jakarta.persistence;
	requires jakarta.validation;
	requires jakarta.xml.bind;
	requires org.hibernate.orm.core;
	requires org.hibernate.commons.annotations;
	requires com.fasterxml.classmate;
	requires net.bytebuddy;

	opens application to javafx.graphics, javafx.fxml;
	opens application.controller to javafx.graphics, javafx.fxml;
	opens application.model to org.hibernate.orm.core, org.hibernate.validator;
}
