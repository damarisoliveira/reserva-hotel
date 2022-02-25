package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exceptions.DomainException;

public class Reservation {
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!this.checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	
	public long duration() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		Date dataAtual = new Date();
		//verificando se as datas de checkin e checkout são antes do dia atual -> dataAtual
		if(this.checkIn.before(dataAtual) || this.checkOut.before(dataAtual)) {
			throw new DomainException("As datas para reserva devem ser futuras.");
		}
		else if(!this.checkOut.after(checkIn)) {
			//verifica se é falso que a data de checOut é depois da de checkIn
			throw new DomainException("A data para o check-out deve ser posterior à data de check-in.");
		}
		
		this.checkIn = checkin;
		this.checkOut = checkout;
	}
	
	@Override
	public String toString() {
		return "Quarto " + roomNumber + ", check-in: " + formato.format(checkIn) + ", check-out: " + formato.format(checkOut) + ", " + duration() + " noites";
	}
	
	
}
