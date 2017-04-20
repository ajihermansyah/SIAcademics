package com.latihan.siacademic.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.latihan.siacademic.model.StudentInfo;

public class StudentValidator implements Validator {

	// The classes is supported to Validate
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == StudentInfo.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		StudentInfo studentInfo = (StudentInfo) target;
		// Check the fields of ApplicantInfo.
		// (See more in property file: messages/validator.property)
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.applicantForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nim", "NotEmpty.applicantForm.nim");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "angkatan", "NotEmpty.applicantForm.angkatan");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "NotEmpty.applicantForm.status");
		
		if (studentInfo.getTahun_angkatan() == null) {
			errors.rejectValue("angkatan", "Select.applicantForm.angkatan");
		}
	}

}
