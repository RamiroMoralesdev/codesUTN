/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collecciones;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author ramiromoralesdev
 */
public class Base {
    private Long id;
    private boolean eliminado;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Base{" + "id=" + id + ", eliminado=" + eliminado + ", createdAt=" + createdAt + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Base)) {
            return false;
        }
        Base base = (Base) o;
        return eliminado == base.eliminado && Objects.equals(id, base.id) && Objects.equals(createdAt, base.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eliminado, createdAt);
    }

    
}
