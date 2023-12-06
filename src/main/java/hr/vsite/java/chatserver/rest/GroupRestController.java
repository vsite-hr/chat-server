package hr.vsite.java.chatserver.rest;

import hr.vsite.java.chatserver.db.Group;
import hr.vsite.java.chatserver.db.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController()
public class GroupRestController {
    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GroupRestController.class);

    @Autowired
    private GroupRepository groupRepository;

    @PutMapping("/groups/{groupName}")
    public void createGroup(@PathVariable String groupName, @RequestBody GroupDTO groupDTO) {
        logger.info("Creating group {} - {}", groupName, groupDTO);
    }

    @DeleteMapping("/groups/{groupName}")
    public void deleteGroup(@PathVariable String groupName) {
        logger.info("Deleting group {}", groupName);
    }

    @GetMapping("/groups")
    public List<GroupDTO> getGroups(String groupName) {
        logger.info("Getting groups {}", groupName);
//        return groupRepository.findAll()
//                .stream().map(this::toDto)
//                .collect(Collectors.toList());
        List<GroupDTO> groupDTOS = new LinkedList<>();
        for (Group group : groupRepository.findAll()) {
            groupDTOS.add(toDto(group));
        }
        return groupDTOS;
    }

    private GroupDTO toDto(Group group) {
        GroupDTO dto = new GroupDTO();
        dto.setGroupName(group.getGroupName());
        return dto;
    }
}
