package br.com.bmo.taskmanager.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.bmo.taskmanager.model.state.TaskState;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid = UUID.randomUUID().toString();
	private String description;
	private String longDescription;
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();
	private LocalDateTime dueDate;
	private Integer sequencyOrder;
	private String priorityLabel;
	// If relation is oneToOne, use @JoinColumn(unique=true)
	@ManyToOne
	private User owner;
	@Enumerated(EnumType.STRING)
	private TaskState status = TaskState.BACKLOG;
	@ManyToMany
	private List<Category> category;
	
	@Deprecated
	public Task() {
		
	}
	
	public Task(String description, LocalDateTime dueDate) {
		this.description = description;
		this.dueDate = dueDate;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getOrder() {
		return sequencyOrder;
	}

	public void setOrder(int order) {
		this.sequencyOrder = order;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public TaskState getState() {
		return status;
	}

	public void setState(TaskState state) {
		this.status = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getPriorityLabel() {
		return priorityLabel;
	}

	public void setPriorityLabel(String priorityLabel) {
		this.priorityLabel = priorityLabel;
	}

	public void setOrder(Integer order) {
		this.sequencyOrder = order;
	}

	public Integer getSequencyOrder() {
		return sequencyOrder;
	}

	public void setSequencyOrder(Integer sequencyOrder) {
		this.sequencyOrder = sequencyOrder;
	}

	public TaskState getStatus() {
		return status;
	}

	public void setStatus(TaskState status) {
		this.status = status;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	
}
