package codingOn.springBootdefault.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class listDTO
{
    private String name;
    private String gender;
    private String date;
    private String interest;
}
///@RequestParam String name, @RequestParam String gender, @RequestParam String date, @RequestParam String interest