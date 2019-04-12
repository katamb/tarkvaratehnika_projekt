package api.iti0208.controller;

import api.iti0208.data.entity.Reply;
import api.iti0208.data.input.ReplyInput;
import api.iti0208.data.input.ReplyPatchInput;
import api.iti0208.service.ReplyService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static api.iti0208.security.SecurityConstants.*;

@RestController
public class ReplyController {

    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping("api/add/reply")
    public Reply save(@RequestBody @Valid ReplyInput item,
                      @RequestHeader(value = HEADER_STRING) String header) {
        return replyService.save(item, header);
    }

    @DeleteMapping("api/delete/reply/{id}")
    @PreAuthorize("@replyService.findUsernameOfReplier(#id) == authentication.name || hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {
        replyService.delete(id);
    }

    @PatchMapping("api/edit/reply/{id}")
    @PreAuthorize("@replyService.findUsernameOfReplier(#id) == authentication.name || hasAuthority('ROLE_ADMIN')")
    public Reply patch(@RequestBody @Valid ReplyPatchInput obj,
                       @PathVariable Long id) {
        return replyService.patch(obj, id);
    }

}
