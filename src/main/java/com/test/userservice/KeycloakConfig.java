package com.test.userservice;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KeycloakConfig {

    static Keycloak keycloak = null;
    public static String serverUrl;
    public static String realm;
    public static String clientId;
    public static String clientSecret ;
    public static String userName;
    public static String password;

    public KeycloakConfig(@Value("${keycloak.serverUrl}") String serverUrl,
                          @Value("${keycloak.realm}") String realm,
                          @Value("${keycloak.clientId}") String clientId,
                          @Value("${keycloak.clientSecret}") String clientSecret,
                          @Value("${keycloak.userName}") String userName,
                          @Value("${keycloak.password}") String password) {
        KeycloakConfig.serverUrl = serverUrl;
        KeycloakConfig.realm = realm;
        KeycloakConfig.clientId = clientId;
        KeycloakConfig.clientSecret = clientSecret;
        KeycloakConfig.userName = userName;
        KeycloakConfig.password = password;
    }

    public static Keycloak getInstance(){
        if(keycloak == null){

            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(userName)
                    .password(password)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .resteasyClient(new ResteasyClientBuilder()
                            .connectionPoolSize(10)
                            .build()
                    )
                    .build();
        }
        return keycloak;
    }

    public static List<String> getAllRoles(){
        List<String> availableRoles = keycloak
                .realm(realm)
                .roles()
                .list()
                .stream()
                .map(role -> role.getName())
                .collect(Collectors.toList());
        return availableRoles;
    }

    public static void addRealmRole(String new_role_name){
        if(!getAllRoles().contains(new_role_name)){
            RoleRepresentation roleRep = new  RoleRepresentation();
            roleRep.setName(new_role_name);
            roleRep.setDescription("role_" + new_role_name);
            keycloak.realm(realm).roles().create(roleRep);
        }
    }

    public static void addRealmRoleToUser(String userName, String role_name) {
        String userId = keycloak
                .realm(realm)
                .users()
                .search(userName)
                .get(0)
                .getId();
        UserResource user = keycloak
                .realm(realm)
                .users()
                .get(userId);
        List<RoleRepresentation> roleToAdd = new LinkedList<>();
        roleToAdd.add(keycloak
                .realm(realm)
                .roles()
                      .get(role_name)
                      .toRepresentation()
                     );
      user.roles().realmLevel().add(roleToAdd);
    }
}
