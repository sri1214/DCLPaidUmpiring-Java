package net.dallascricket.paidUmpiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dallascricket.paidUmpiring.Request.ReservationReq;
import net.dallascricket.paidUmpiring.Request.UmpireReq;
import net.dallascricket.paidUmpiring.domain.Greeting;
import net.dallascricket.paidUmpiring.jpa.model.Reservation;
import net.dallascricket.paidUmpiring.jpa.model.Reservation.ReservationBuilder;
import net.dallascricket.paidUmpiring.jpa.model.Umpire;
import net.dallascricket.paidUmpiring.jpa.repository.ReservationRepository;
import net.dallascricket.paidUmpiring.jpa.repository.UmpireRepository;

@RestController
@RequestMapping(path="/umpiringReservations")
public class MainController {
	private static final String template = "Hello, %s!";
	
	@Autowired
	private UmpireRepository umpireRepository ;
	
	@Autowired
	private ReservationRepository reservationRepository ;
	
    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(String.format(template, name));
    }

    @PostMapping("/umpire") 
    public void createNewUmpire(@RequestBody UmpireReq newUmpireRequest){
    	
    	umpireRepository.save(new Umpire(newUmpireRequest.getName(), newUmpireRequest.isCertified()));
    	
    }
    
    @PostMapping("/reservation") 
    public void createNewReservation(@RequestBody ReservationReq reservationReq){
    	
    	Reservation reservation = new ReservationBuilder(reservationReq).build();
    	
    	reservationRepository.save(reservation);
    	
    }
}
