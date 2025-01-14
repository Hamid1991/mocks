package in.neuw.mocks.controllers;

import in.neuw.mocks.models.HealthStatus;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ResourceController {

    @GetMapping("/public")
    public HealthStatus getPublic(@RequestHeader("Authorization") String token,
                             HttpServletRequest request) {
        logAuthorizationHeader(token, request);
        return new HealthStatus().setStatus("public");
    }

    @GetMapping("/private")
    public HealthStatus getPrivate(@RequestHeader("Authorization") String token,
                             HttpServletRequest request) {
        logAuthorizationHeader(token, request);
        return new HealthStatus().setStatus("private");
    }

    private static void logAuthorizationHeader(String token, HttpServletRequest request) {
        log.info("input Authorization - {} on port - {}", token, request.getServerPort());
    }

}
