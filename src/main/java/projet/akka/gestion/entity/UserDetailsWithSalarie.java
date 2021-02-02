package projet.akka.gestion.entity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsWithSalarie implements UserDetails {

	private Salarie salarie;

	public UserDetailsWithSalarie(Salarie salarie) {
		super();
		this.salarie = salarie;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(salarie.getRole().toString()));
	}

	@Override
	public String getPassword() {
		return salarie.getPassword();
	}

	@Override
	public String getUsername() {
		return salarie.getMail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
