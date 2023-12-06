package hr.vsite.java.chatserver.rest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class GroupRestController {
    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GroupRestController.class);

    @PutMapping("/groups/{groupName}")
    public void createGroup(@RequestParam String groupName) {
        logger.info("Creating group {}", groupName);
    }

    @DeleteMapping("/groups/{groupName}")
    public void deleteGroup(@RequestParam String groupName) {
        logger.info("Deleting group {}", groupName);
    }

    @GetMapping("/groups")
    public List<GroupDTO> getGroups(String groupName) {
        logger.info("Getting groups {}", groupName);
        return null;
    }

}
