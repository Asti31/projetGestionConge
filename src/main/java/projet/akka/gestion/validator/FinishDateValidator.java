package projet.akka.gestion.validator;

import java.time.LocalDate;
import java.time.Month;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FinishDateValidator implements ConstraintValidator<FinishDate, LocalDate> {
	
	private LocalDate dateDebut;
	
	@Override
	public void initialize(FinishDate contraintValidator) {
		
		this.dateDebut= LocalDate.parse(contraintValidator.dateDebut());
	}
	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		return value.isAfter(dateDebut);
	}

}
