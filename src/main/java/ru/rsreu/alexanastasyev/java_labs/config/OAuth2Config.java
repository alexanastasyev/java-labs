package ru.rsreu.alexanastasyev.java_labs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private String clientid = "id";
    private String clientSecret = "secret";
    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEAwb63iJNLw/MSt44NoVT08RNmgF6u8KzKdg5hcheapXapqrMW\n" +
            "/Ub1t8ajg3wxx8QFKbX8KJenG6AOY3COwL1Ik/9kAlVJvDSVod17iNFID2XAZsa9\n" +
            "4PgcCbeUNrQza4sdrV/Trzb05aKzUNi9+2ymlmQmUmMXNC4qiXPN9UCqCsHB7BwF\n" +
            "JhsgjxKKIxDywAQU9vMhb0zduVivlVpEbLf/Rp/2kDAFe7aJy5WxBvjUuv0aBnWS\n" +
            "8yQdjjPfZDHpToacWQiiTo+CqOPPABdmO65zoPtaJ+hF/jlfhHQyLYMeDW3K7cKO\n" +
            "3Ewpvxmpd3TG/KhXbbSoc6hiaQB7uB3+fJ4DHwIDAQABAoIBAEA7GR+XLZQd3sOp\n" +
            "vY0R3E6cDuxZ94dk0Y5IADhR6PwYFfG4g9OeFdJCcW0i3GIM82U7pwhSFp2K95ox\n" +
            "87GkTw55qc84NUTG7iCGi/D06P3pztqD4ulVd/4ktWdZYH6z1TfoQAajopcK1IXm\n" +
            "BT34bFYJh8bigQvUjleZY9t9/6Gmu+cpKShY5ASXh/IKjDeoQXPOVdR3Mff7AO/Q\n" +
            "54CCIJE8K+d0AQnhjmp2VqmtvMOTde89VLhyLce67cWso86xeTXf1looBAU6rPHC\n" +
            "m+uM9KuZGW+Qc0Q6CRLMASz6OgvahyH7b5DGZg7UWvHvn385rX9yNPQ/kKIg1hfb\n" +
            "uFeJJlECgYEA/NTaDv3Dy3hdDacCAfrsjwnn/Qu3j3e8+LX8Wx8pjCiQkkV4e2cO\n" +
            "lEfKxUvHO6aIi884aKc8nC20SajpLh+RXvidOzf44/AWmH4U+cMgvWRqPgj2W1ID\n" +
            "OMytEhk9o6qn3IVP/qLbeF7Yf+Pmd7xkoBPMxW5Ib60ytTIJJL0uX8kCgYEAxCxM\n" +
            "83ENA++5x9PSKbZwyWFmIahkpnts+U4H2QC3ASDnHgZnFQiwlJRQkbBHQsrb0uNe\n" +
            "EAkoP3pjXBWIpV61nW+VSX2QUHKFqsXt8wmuVdAxhHWke81vURcJ/eLo0dLIiQ9g\n" +
            "V0/i7Ummk+Ma6u+cWRbRvhzT6eZ5igwiTc2az6cCgYATJ3kBq736mzrJfv6K8dyc\n" +
            "FY8Kv6l/Z/3cBcWBjcHTCXuyaSrwhmU3XJ0DB3OnlD1CAkfuvcS8vEWtUuuff+q+\n" +
            "fC1FQD9N3XGIyfyC04KWdpYJ7xni3zq5QeBWv6zIynP/I+Zkjyf7XYwfXD+okJA7\n" +
            "BGT+DBXWyBNQYOMKcn6h6QKBgQChoI5WFNLQZ3b9uPvy+im7AdCP8pnawN5sGWpF\n" +
            "1FzzRRSmnEfaAKrb/8bSAhb0ZQbwnfwl4iWTB1dNy0AmX/3qlMC/KAD7ByAyL5l5\n" +
            "IITOlxX1OKgoiH4qpXzJ/WYtWil3I4AQ7/Tb5E6mkfrfjkOW80IkDMRcdlO09YJd\n" +
            "8ASZCQKBgQCfRACBqidvWd0uCBamdS33zOvZEBR4UmdTMaOsuCBfq8ryrKSVCMdp\n" +
            "nq433fDx/v/cMusKo6/BHVOApa5bWEca8gVMCZprdies2uvb0F6ggL5jTeVqdhDc\n" +
            "itlTWSUSRjMVXQ+VxdsfHzr4yY6y7EeSH+DKgVyAJZVvj/e8z9YYyg==\n" +
            "-----END RSA PRIVATE KEY-----";
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwb63iJNLw/MSt44NoVT0\n" +
            "8RNmgF6u8KzKdg5hcheapXapqrMW/Ub1t8ajg3wxx8QFKbX8KJenG6AOY3COwL1I\n" +
            "k/9kAlVJvDSVod17iNFID2XAZsa94PgcCbeUNrQza4sdrV/Trzb05aKzUNi9+2ym\n" +
            "lmQmUmMXNC4qiXPN9UCqCsHB7BwFJhsgjxKKIxDywAQU9vMhb0zduVivlVpEbLf/\n" +
            "Rp/2kDAFe7aJy5WxBvjUuv0aBnWS8yQdjjPfZDHpToacWQiiTo+CqOPPABdmO65z\n" +
            "oPtaJ+hF/jlfhHQyLYMeDW3K7cKO3Ewpvxmpd3TG/KhXbbSoc6hiaQB7uB3+fJ4D\n" +
            "HwIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        security.allowFormAuthenticationForClients();
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);

    }
}
