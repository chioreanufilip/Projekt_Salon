package repository;

import Module.Appointment;
import Module.Review;
import Module.Payment;
import Module.HasId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;



public class InMemoryRepository<T extends HasId> implements Repository<T> {
    private final Map<Integer, T> data = new HashMap<>();

    private final List<Appointment> appointments = new ArrayList<>();
    private final List<Review> reviews = new ArrayList<>();
    private final List<Payment> payments = new ArrayList<>();

    @Override
public void create(T object) {
    data.putIfAbsent(object.getId(), object);
//    System.out.println(data.get(object.getId()));
    }
    @Override
public void update(T object) {
    data.replace(object.getId(), object);
}
@Override
public void delete(Integer id) {
    data.remove(id);
}
@Override
public List<T> getAll() {
    return data.values().stream().toList();
}
@Override
public T getById(int id) {
    return data.get(id);
}

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Payment> getPayments() {
        return payments;
    }

}
