package hu.hjst.jobmanager.utils;

import hu.hjst.jobmanager.models.dtos.CustomerCreateDto;

public class Validator {

  //TODO : overloaded constructors
  public static void validate(CustomerCreateDto dto) {
    String companyName = dto.getCompanyName();
    if (companyName == null || companyName.isEmpty()) {
      throw new IllegalArgumentException("Please fill the company name!");
    }
  }

  public static void validate(String text, String message) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException(message);
    }
  }

}
