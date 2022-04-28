package com.bruno.adsaude.web.controller.util;

import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.DoubleValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.IntegerValidator;
import org.apache.commons.validator.routines.LongValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.web.controller.Errors;


/**
 * @author Admin
 *
 */
public class ValidationUtils {
	private static Logger logger = LogManager.getLogger(ValidationUtils.class);
	private static final Pattern NOT_A_NUMBER = Pattern.compile("(\\s*[a-zA-ZÀ-úñÑ]{2,20}){1,5}");
	private static final Pattern TELEPHONE = Pattern.compile("^[6,8,9][0-9]{8}$|^\\\\+[0-9]{2}\\\\s[1-9][0-9]{8}$");
	private static final Pattern PASSWORD = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
	private static final Pattern DNI = Pattern.compile("[0-9]{7,8}[A-Za-z]");
	private static EmailValidator mail  = EmailValidator.getInstance();
	private static DoubleValidator doubleVald = DoubleValidator.getInstance();
	private static IntegerValidator intVald = IntegerValidator.getInstance();
	private static LongValidator longVald = LongValidator.getInstance();
	

	public ValidationUtils() {

	}


	public static String passwordValidation(Map<String, String[]> mapParameter,  Errors error) {
		if(mapParameter.get(ParameterNames.PASSWORD) == null) {
			error.addParameterError(ParameterNames.PASSWORD, ErrorNames.ERR_MANDATORY);
			return null;
		}
		String password = mapParameter.get(ParameterNames.PASSWORD)[0];
		password = password.trim();
		if(StringUtils.isBlank(password)) {
			error.addParameterError(ParameterNames.PASSWORD, ErrorNames.ERR_MANDATORY);
		}
		if(!PASSWORD.matcher(password).matches()) {
			error.addParameterError(ParameterNames.PASSWORD, ErrorNames.ERR_NAME);
		}

		if(error.getParameterError(ParameterNames.PASSWORD) == null) {
			return password;
		}
		else {
			logger.debug(new StringBuilder("errores encontrados en el campo ")
					.append(ParameterNames.PASSWORD).append(" ")
					.append(error.getParameterError(ParameterNames.PASSWORD)).toString());
			return null;
		}

	}
	
	public static String numberNotValidator(Map<String, String[]> mapParameter, String parameter, Errors error) {
		if(mapParameter.get(parameter) == null) {
			error.addParameterError(parameter, ErrorNames.ERR_MANDATORY);
			return null;
		}
		String nombre = mapParameter.get(parameter)[0];
		nombre = nombre.trim();
		if(StringUtils.isBlank(nombre)) {
			error.addParameterError(parameter, ErrorNames.ERR_MANDATORY);
		}
		if(!NOT_A_NUMBER.matcher(nombre).matches()) {
			error.addParameterError(parameter, ErrorNames.ERR_NAME);
		}

		if(error.getParameterError(parameter) == null) {
			return nombre;
		}
		else {
			logger.debug(new StringBuilder("errores encontrados en el campo ")
					.append(parameter).append(" ")
					.append(error.getParameterError(parameter)).toString());
			return null;
		}
	}

	public static String telefonoValidator(Map<String, String[]> mapParameter, Errors error, String param) {
		if(mapParameter.get(param) == null) {
			error.addParameterError(param, ErrorNames.ERR_MANDATORY);
			return null;
		}
		String telefono = mapParameter.get(param)[0];
		telefono = telefono.trim();
		if(StringUtils.isBlank(telefono)) {
			error.addParameterError(param, ErrorNames.ERR_MANDATORY);
		}
		if(!TELEPHONE.matcher(telefono).matches()) {
			error.addParameterError(param, ErrorNames.ERR_NAME);
		}

		if(error.getParameterError(param) == null) {
			return telefono;
		}
		else {
			logger.debug(new StringBuilder("errores encontrados en el campo ")
					.append(param).append(" ")
					.append(error.getParameterError(param)).toString());
			return null;
		}
	}
	
	public static String emailValidator(Map<String, String[]> mapParameter,  Errors error) {
		if(mapParameter.get(ParameterNames.EMAIL) == null) {
			error.addParameterError(ParameterNames.EMAIL, ErrorNames.ERR_MANDATORY);
			return null;
		}
		String email = mapParameter.get(ParameterNames.EMAIL)[0];
		email = email.trim();
		if(StringUtils.isBlank(email)) {
			error.addParameterError(ParameterNames.EMAIL, ErrorNames.ERR_MANDATORY);
		}
		if(!mail.isValid(email)) {
			error.addParameterError(ParameterNames.EMAIL, ErrorNames.ERR_EMAIL);
		}

		if(error.getParameterError(ParameterNames.EMAIL) == null) {
			return email;
		}
		else {
			logger.debug(new StringBuilder("errores encontrados en el campo ")
					.append(ParameterNames.EMAIL).append(" ")
					.append(error.getParameterError(ParameterNames.EMAIL)).toString());
			return null;
		}
	}


	public static String dniValidation(Map<String, String[]> mapParameter,  Errors error) {
		if(mapParameter.get(ParameterNames.NIF) == null) {
			error.addParameterError(ParameterNames.NIF, ErrorNames.ERR_MANDATORY);
			return null;
		}
		String password = mapParameter.get(ParameterNames.NIF)[0];
		password = password.trim();
		if(StringUtils.isBlank(password)) {
			error.addParameterError(ParameterNames.NIF, ErrorNames.ERR_MANDATORY);
		}
		if(!DNI.matcher(password).matches()) {
			error.addParameterError(ParameterNames.NIF, ErrorNames.ERR_NAME);
		}

		if(error.getParameterError(ParameterNames.NIF) == null) {
			return password;
		}
		else {
			logger.debug(new StringBuilder("errores encontrados en el campo ")
					.append(ParameterNames.NIF).append(" ")
					.append(error.getParameterError(ParameterNames.NIF)).toString());
			return null;
		}

	}
	
	public static Integer integerValidator(Map<String, String[]> mapParameter, String parameter, Errors error, Integer minValue, Integer maxValue, Boolean mandatory) {

		if(mapParameter.get(parameter) == null && mandatory ==true) {
			error.addParameterError(parameter, ErrorNames.ERR_MANDATORY);
			return null;
		}
		String []numberParam = mapParameter.get(parameter);
		String number = null;

		if(numberParam != null) {
			number = numberParam[0];
		}
		Integer num = null;
		if(StringUtils.isBlank(number) && mandatory ==true) {
			error.addParameterError(parameter, ErrorNames.ERR_MANDATORY);
			logger.debug(new StringBuilder("errores encontrados en el campo ")
					.append(parameter).append(" ")
					.append(error.getParameterError(parameter)).toString());
			return null;

		}
		else if(!StringUtils.isBlank(number)){


			try {
				num = Integer.valueOf(number);
			}catch(NumberFormatException e) {
				logger.warn(e.getMessage(), e);
				error.addParameterError(parameter, ErrorNames.NOT_NUMBER_FORMAT);
				return null;
			}
			if(!intVald.isInRange(num, minValue, maxValue)) {
				error.addParameterError(parameter, ErrorNames.ERR_NUMBER_LIMIT);
				logger.debug(new StringBuilder("errores encontrados en el campo ")
						.append(parameter).append(" ")
						.append(error.getParameterError(parameter)).toString());
				return null;
			}
			return num;
		}



		return num;
	}
	public static Double doubleValidator(Map<String, String[]> mapParameter, String parameter, Errors error, Double minValue, Double maxValue, Boolean mandatory) {
		if(mapParameter.get(parameter) == null && mandatory ==true) {
			error.addParameterError(parameter, ErrorNames.ERR_MANDATORY);
			return null;
		}
		String []numberParam = mapParameter.get(parameter);
		String number = null;
		if(numberParam != null) {
			number = numberParam[0];
		}
		Double num = null;
		if(StringUtils.isBlank(number) && mandatory ==true) {
			error.addParameterError(parameter, ErrorNames.ERR_MANDATORY);
			logger.debug(new StringBuilder("errores encontrados en el campo ")
					.append(parameter).append(" ")
					.append(error.getParameterError(parameter)).toString());
			return null;

		}
		else if(!StringUtils.isBlank(number)){
			try {

				num = Double.valueOf(number.replace(',', '.'));

			}catch(NumberFormatException e) {
				logger.warn(e.getMessage(), e);
				error.addParameterError(parameter, ErrorNames.NOT_NUMBER_FORMAT);
				return null;
			}
			if(!doubleVald.isInRange(num, minValue, maxValue)) {
				error.addParameterError(parameter, ErrorNames.ERR_NUMBER_LIMIT);
				logger.debug(new StringBuilder("errores encontrados en el campo ")
						.append(parameter).append(" ")
						.append(error.getParameterError(parameter)).toString());
				return null;
			}
			return num;
		}

		return num;


	}
	public static Long longValidator(Map<String, String[]> mapParameter, String parameter, Errors error, Long minValue, Long maxValue, Boolean mandatory) {
		if(mapParameter.get(parameter) == null && mandatory ==true) {
			error.addParameterError(parameter, ErrorNames.ERR_MANDATORY);
			return null;
		}
		String []numberParam = mapParameter.get(parameter);
		String number = null;
		if(numberParam != null) {
			number = numberParam[0];
		}
		Long num = null;
		if(StringUtils.isBlank(number) && mandatory ==true) {
			error.addParameterError(parameter, ErrorNames.ERR_MANDATORY);
			logger.debug(new StringBuilder("errores encontrados en el campo ")
					.append(parameter).append(" ")
					.append(error.getParameterError(parameter)).toString());
			return null;

		}
		else if(!StringUtils.isBlank(number)){
			try {
				num = Long.valueOf(number);

			}catch(NumberFormatException e) {
				logger.warn(e.getMessage(), e);
				error.addParameterError(parameter, ErrorNames.NOT_NUMBER_FORMAT);
				return null;
			}
			if(!longVald.isInRange(num, minValue, maxValue)) {
				error.addParameterError(parameter, ErrorNames.ERR_NUMBER_LIMIT);
				logger.debug(new StringBuilder("errores encontrados en el campo ")
						.append(parameter).append(" ")
						.append(error.getParameterError(parameter)).toString());
				return null;
			}
			return num;
		}
		return num;
	}

	



}
