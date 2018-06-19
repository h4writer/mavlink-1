package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Request a partial list of mission items from the system/component. 
 * https://mavlink.io/en/protocol/mission.html. If start and end index are the same, just 
 * send one waypoint. 
 */
@MavlinkMessage(
    id = 37,
    crc = 212
)
public final class MissionRequestPartialList {
  /**
   * Start index, 0 by default 
   */
  private final int startIndex;

  /**
   * End index, -1 by default (-1: send list to end). Else a valid index of the list 
   */
  private final int endIndex;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
   */
  private final MavMissionType missionType;

  private MissionRequestPartialList(int startIndex, int endIndex, int targetSystem,
      int targetComponent, MavMissionType missionType) {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.missionType = missionType;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MissionRequestPartialList{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", startIndex=" + startIndex
         + ", endIndex=" + endIndex
         + ", missionType=" + missionType + "}";
  }

  /**
   * Start index, 0 by default 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int startIndex() {
    return startIndex;
  }

  /**
   * End index, -1 by default (-1: send list to end). Else a valid index of the list 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 2
  )
  public final int endIndex() {
    return endIndex;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 1,
      extension = true
  )
  public final MavMissionType missionType() {
    return missionType;
  }

  public static class Builder {
    private int startIndex;

    private int endIndex;

    private int targetSystem;

    private int targetComponent;

    private MavMissionType missionType;

    private Builder() {
    }

    /**
     * Start index, 0 by default 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder startIndex(int startIndex) {
      this.startIndex = startIndex;
      return this;
    }

    /**
     * End index, -1 by default (-1: send list to end). Else a valid index of the list 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 2
    )
    public final Builder endIndex(int endIndex) {
      this.endIndex = endIndex;
      return this;
    }

    /**
     * System ID 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Component ID 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 1,
        extension = true
    )
    public final Builder missionType(MavMissionType missionType) {
      this.missionType = missionType;
      return this;
    }

    public final MissionRequestPartialList build() {
      return new MissionRequestPartialList(startIndex, endIndex, targetSystem, targetComponent, missionType);
    }
  }
}