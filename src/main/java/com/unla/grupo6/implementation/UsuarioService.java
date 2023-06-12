//package com.unla.grupo6.implementation;
//
//import java.util.List;
//import java.util.Set;
//import java.util.ArrayList;
//import java.util.HashSet;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.unla.grupo6.entities.Usuario;
//import com.unla.grupo6.entities.UsuarioAdministrador;
//import com.unla.grupo6.repositories.IUsuarioRepository;
//
//
////REVISAR BIEN CON MUCHO DETALLE
//
//
//
//
//@Service("userService")
//public class UsuarioService implements UserDetailsService{
//	
//	@Autowired 
//	@Qualifier ("userRepository")
//	private IUsuarioRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//		com.unla.grupo6.entities.Usuario usuario = userRepository.findByUsuarioAndFetchUsuarioAdministradorEagerly(username);
//		return buildUser(usuario, buildGrantedAuthorities(usuario.getUsuarioAdministrador()));
//		
//	}
//	
//
//
//private UserDetails buildUser(Usuario usuario, List<GrantedAuthority> buildGrantedAuthorities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
////	private Usuario buildUser (com.unla.grupo6.entities.Usuario user , List<GrantedAuthority> grantedAuthorities) {
////		return new Usuario (user.getUsuario(),  user.getContraseña(), user.isActivado(), true, true, true, grantedAuthorities); //error aca grantedAuthoritys
////	}
//
//	
////	private Object grantedAuthorities() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
//	private List<GrantedAuthority> buildGrantedAuthorities(Set<UsuarioAdministrador> usuarioAdministradores){
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>(); //error en el hashset
//		for(UsuarioAdministrador usuarioAdmin : usuarioAdministradores) {
//			grantedAuthorities.add(new SimpleGrantedAuthority(usuarioAdmin.getRole()));
//		}
//		
//		return new ArrayList<GrantedAuthority> (grantedAuthorities);
//	}
//	
//	
////	private UserDetails buildUser(Usuario usuario, Object buildGrantedAuthorities) {
////		// TODO Auto-generated method stub
////		return null;
////	}
////
////	private Object buildGrantedAuthorities(Object userRoles) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//}
