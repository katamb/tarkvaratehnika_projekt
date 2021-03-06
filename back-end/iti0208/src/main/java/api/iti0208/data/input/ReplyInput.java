package api.iti0208.data.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyInput {

    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String reply;

    @NotNull
    private Long postId;

    private String fileLocation;
}
