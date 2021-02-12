package projet.akka.gestion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "page introuvable")
public class ServiceNotFoundException extends RuntimeException {

}
